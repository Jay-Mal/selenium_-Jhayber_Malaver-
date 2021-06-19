import org.testng.annotations.DataProvider;

public class dataProvider {
    @DataProvider(name = "userEmail")
    public Object[][] crearEmail(){
        return new Object[][] {
                {"abc@gmail.com"},
                {"testprueba@gmail.com"},
                {"newemail@yahoo.com"}
        };
    }
}
