package com.nttdata.steps;

import com.nttdata.model.Order;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OrdenStep {
    private String URL_BASE = "https://petstore.swagger.io/v2";
    Order cOrden = new Order();
    public void consultaOrden(int id){

        cOrden =
            SerenityRest.given()
                            .baseUri(URL_BASE)
                            .log()
                            .all()
                            .when()
                            .get("/store/order/"+id)
                            .as(Order.class)
                    ;
        assertThat(lastResponse().getBody().path("id"), equalTo(id));
    }
    public void ordenMascota(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5){
        int id = Integer.parseInt(arg0);
        int petid = Integer.parseInt(arg1);
        int quantity = Integer.parseInt(arg2);

        Order orden = new Order(id,petid,quantity,arg3,arg4,Boolean.valueOf(arg5));

        SerenityRest.given()
                .contentType("application/json")
                .body("{ \"id\": "+orden.getId()
                        +", \"petId\":"+orden.getPetId()
                        +", \"quantity\":"+orden.getQuantity()
                        +", \"shipDate\": \""+orden.getShipDate() +"\""
                        +", \"status\": \""+orden.getStatus()
                        +"\", \"complete\":"+ orden.isComplete() +"}")

                .post(URL_BASE + "/store/order")
                .then()
                .log()
                .all();

    }

    public void validoPetId(int petid){
        assertThat(lastResponse().getBody().path("petId"), equalTo(petid));
    }

    public void validoRegistroCompletado(){
        assertThat(lastResponse().getBody().path("complete"), equalTo(true));
    }

    public void validacionCodigoRespuesta(int codigo){
        Assert.assertEquals(codigo, SerenityRest.lastResponse().statusCode());
    }

    public void validacionDePetIdyStatus(String petid, String status){
        assertThat(petid, equalTo(cOrden.getPetId()+""));
        assertThat(status, equalTo(cOrden.getStatus()));
    }

}