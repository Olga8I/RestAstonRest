package repository;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.example.model.Department;
import org.example.repository.dao.DepartmentRepositoryDao;
import org.example.util.PropertiesUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


import java.util.Optional;

@Testcontainers
@Tag("DockerRequired")
class DepartmentRepositoryDaoTest {
    private static final String INIT_SQL = "sql/schema.sql";
    public static DepartmentRepositoryDao departmentRepositoryDao;
    private static int containerPort = 5432;
    private static int localPort = 5432;
    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("users_db")
            .withUsername(PropertiesUtil.getProperties("db.username"))
            .withPassword(PropertiesUtil.getProperties("db.password"))
            .withExposedPorts(containerPort)
            .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
                    new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(localPort), new ExposedPort(containerPort)))
            ))
            .withInitScript(INIT_SQL);


    @BeforeAll
   // static void beforeAll() {
    //    container.start();
    //    departmentRepositoryDao = new DepartmentRepositoryDao(new DepartmentRepositoryDao()); // Инициализация DAO
     //   jdbcDatabaseDelegate = new JdbcDatabaseDelegate(container, "");
   // }

    @AfterAll
    static void afterAll() {
        container.stop();
    }

  //  @BeforeEach
 //   void setUp() {
 ///       ScriptUtils.runInitScript(jdbcDatabaseDelegate, INIT_SQL);
  ///  }

    @Test
    void save() {
        String expectedName = "new Department Yo!";
        Department department = new Department();
        departmentRepositoryDao.add(department); // Используем метод DAO
        Optional<Department> resultDepartment = departmentRepositoryDao.findById(department.getId()); // Используем метод DAO

        Assertions.assertTrue(resultDepartment.isPresent());
        Assertions.assertEquals(expectedName, resultDepartment.get().getName());
    }

    @Test
    void update() {
        String expectedName = "Update department name";

        Optional<Department> department = departmentRepositoryDao.findById(2L); // Используем метод DAO
        String oldName = department.get().getName();
        int expectedSizeUserList = department.get().getUserList().size();
        department.get().setName(expectedName);
        departmentRepositoryDao.update(department.orElse(null)); // Используем метод DAO

        Optional<Department> resultDepartment = departmentRepositoryDao.findById(2L); // Используем метод DAO
        int resultSizeUserList = resultDepartment.get().getUserList().size();

        Assertions.assertNotEquals(expectedName, oldName);
        Assertions.assertEquals(expectedName, resultDepartment.get().getName());
        Assertions.assertEquals(expectedSizeUserList, resultSizeUserList);
    }

    @Test
    void deleteById() {
        Boolean expectedValue = true;
        int expectedSize = departmentRepositoryDao.findAll().size(); // Используем метод DAO

        Department tempDepartment = new Department();
        departmentRepositoryDao.add(tempDepartment); // Используем метод DAO

        int resultSizeBefore = departmentRepositoryDao.findAll().size(); // Используем метод DAO
        Assertions.assertNotEquals(expectedSize, resultSizeBefore);

        departmentRepositoryDao.delete(tempDepartment.getId()); // Используем метод DAO
        int resultSizeAfter = departmentRepositoryDao.findAll().size(); // Используем метод DAO

        Assertions.assertEquals(expectedValue, expectedSize != resultSizeAfter); // Проверяем удаление
    }

    @DisplayName("Find by ID")
    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "4, true",
            "1000, false"
    })
    void findById(Long expectedId, Boolean expectedValue) {
        Optional<Department> department = departmentRepositoryDao.findById(expectedId); // Используем метод DAO
        if (expectedValue) {
            Assertions.assertNotNull(department);
            Assertions.assertEquals(expectedId, department.get().getId());
        } else {
            Assertions.assertNull(department); // Проверяем, что возвращается null, если нет
        }
    }

    @Test
    void findAll() {
        int expectedSize = 4;
        int resultSize = departmentRepositoryDao.findAll().size(); // Используем метод DAO

        Assertions.assertEquals(expectedSize, resultSize);
    }

    @DisplayName("Exist by ID")
    @ParameterizedTest
    @CsvSource(value = {
            "1; true",
            "4; true",
            "100; false"
    }, delimiter = ';')
    void exitsById(Long departmentId, Boolean expectedValue) {
        boolean isDepartmentExist = departmentRepositoryDao.findById(departmentId) != null; // Используем метод DAO

        Assertions.assertEquals(expectedValue, isDepartmentExist);
    }
}


