
@PetStore
Feature: Creación y Consulta de una orden para compra de mascota

  Scenario Outline: Creacion de Orden
      Given dado que necesito crear una orden de compra
      When ingreso los siguientes datos: <"id"> <"petId"> <"quantity"> <"shipDate"> <"status"> <"complete">
      Then valido el codigo de respuesta 200
      And valido que el petid sea 1
      And valido que el registro marque completado
      Examples:
        |"id" |"petId" |"quantity" |"shipDate"                   |"status"   |"complete" |
        |<"2">|<"1">   |<"1">      |<"2024-06-30T02:22:46.700">  |<"placed"> |<"true">   |

  Scenario Outline: Consulta de Orden
    Given dado que estoy en la tienda
    When consulto el orden de compra de una mascota con ID 2
    And valido que el petid sea <"petid"> y el status sea <"status">
    Then valido codigo de respuesta de la consulta sea 200

    Examples:
      | "petid" | "status" |
      |<"1"> |<"placed">|

