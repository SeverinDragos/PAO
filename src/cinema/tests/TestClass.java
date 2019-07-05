package cinema.tests;

import cinema.domain.entity.Movie;
import org.junit.*;

public class TestClass {
  @BeforeClass
  public static void beforeClass() {
    System.out.println("BeforeClass");
  }

  @Before
  public void before() {
    System.out.println("Before");
  }

  @Test
  public void testSearchForMovie() {
    System.out.println("The actual test");
    Movie movie = new Movie("drama", "The Departed", 151, "2D", 18);
    Assert.assertEquals("drama", movie.getGenre());
  }

  @After
  public void after() {
    System.out.println("After");
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("AfterClass");
  }
}
