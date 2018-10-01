package tests;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.codehaus.groovy.ast.tools.GeneralUtils.param;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;


public class apiProdutosTest {

    public apiProdutosTest(){
        baseURI = "http://52.191.254.38/desafio/produtos";
    }

    @Test
    public void consultaProdutoInexistente() {

        given()
                .when()
                .get("99")
                .then()
                .statusCode(404)
                .body("message", containsString("Produto não encontrado!"));
    }

    @Test
    public void consultaProdutoExistente() {

         given()
                .when()
                .get("1")
                .then()
                .statusCode(200)
                .body("nome", is("Chocolate"))
                .body("descricao", is("Chocolate ao leite"))
                .body("valor_venda", is("2.00"))
                .body("estoque", is("10.00"))
                .body("endereco_foto", is("teste"))
                .body("codigo_barras", is("78912344412"))
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema_exemplo.json"));
    }
}

