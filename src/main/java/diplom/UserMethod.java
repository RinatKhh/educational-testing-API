package diplom;

import io.restassured.response.Response;
public class UserMethod extends ApiSetting {
    //создать пользователя
    public static Response createUser(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(REGISTER);
    }
    //удалить пользователя по токену
    public  static void deleteUser(String accessToken) {
        getSpec().auth()
                .oauth2(getAccessToken(accessToken))
                .delete(DELETE);
    }
    //залогиниться под пользователем
    public static Response sigInUser(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(SIGNIN);
    }
    // поменять данные пользователя
    public static Response changDataUser(String accessToken, User newDataUser) {
        return getSpec().given().auth()
                .oauth2(getAccessToken(accessToken))
                .body(newDataUser)
                .when()
                .patch(EDITUSER);
    }
}
