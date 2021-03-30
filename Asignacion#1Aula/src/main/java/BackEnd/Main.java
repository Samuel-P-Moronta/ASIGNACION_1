package BackEnd;

import io.javalin.Javalin;


import static io.javalin.apibuilder.ApiBuilder.*;


public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.routes(() -> {
            path("/", () -> {
                before("/", ctx -> {
                    User usuario = ctx.sessionAttribute("user");
                    if (usuario == null) {
                        ctx.redirect("/Public/index.html");
                    } else {
                        System.out.println("Verificando....");
                    }
                });
                get("/", ctx -> {
                    ctx.redirect("/Public/index.html");
                });
            });

            path("/", () -> {
                get("/Public/index.html", ctx -> {
                    ctx.render("/Public/index.html");
                });
            });
        });
        app.post("/autenticar", ctx -> {
            User user = new User(ctx.formParam("username"), ctx.formParam("password"));
            if ((user.getUser().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase("admin"))) {
                System.out.println("Iniciando...");
            } else {
                System.out.print("\n Usuario no encontrado. Revise su nombre  de usuario y su password");
            }

        });
    }
}
