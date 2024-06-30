package com.nttdata.glue;

import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OrdenStepdefs {

    @Steps
    OrdenStep ordenMascota;

    @Given("dado que necesito crear una orden de compra")
    public void dadoQueNecesitoCrearUnaOrdenDeCompra() {
    }
//    @When("ingreso los siguientes datos: id {int} petId {int} quantity {int} shipDate {string} status {string} complete {string}")
//    public void ingresoLosSiguientesDatosIdPetIdQuantityShipDateStatusComplete(int arg0, int arg1, int arg2, String arg3, String arg4, String arg5) {
//        ordenMascota.ordenMascota(arg0,arg1,arg2,arg3,arg4,arg5);
//    }
    @When("ingreso los siguientes datos: <{string}> <{string}> <{string}> <{string}> <{string}> <{string}>")
    public void ingresoLosSiguientesDatos(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        ordenMascota.ordenMascota(arg0,arg1,arg2,arg3,arg4,arg5);
    }

    @Then("valido el codigo de respuesta {int}")
    public void validoElCodigoDeRespuesta(int arg0) {
        ordenMascota.validacionCodigoRespuesta(arg0);
    }

    @And("valido que el petid sea {int}")
    public void validoQueElPetidSea(int arg0) {
        ordenMascota.validoPetId(arg0);
    }

    @And("valido que el registro marque completado")
    public void validoQueElRegistroMarqueCompletado() {
        ordenMascota.validoRegistroCompletado();
    }

    @Given("dado que estoy en la tienda")
    public void dadoQueEstoyEnLaTienda() {
    }

    @When("consulto el orden de compra de una mascota con ID {int}")
    public void consultoElOrdenDeCompraDeUnaMascotaConID(int arg0) {
        ordenMascota.consultaOrden(arg0);
    }

    @And("valido que el petid sea <{string}> y el status sea <{string}>")
    public void validoQueElYElSea(String arg0, String arg1) {
        ordenMascota.validacionDePetIdyStatus(arg0, arg1);
    }
    @Then("valido codigo de respuesta de la consulta sea {int}")
    public void validoCodigoDeRespuestaDeLaConsultaSea(int arg0) {
        ordenMascota.validacionCodigoRespuesta(arg0);
    }


}
