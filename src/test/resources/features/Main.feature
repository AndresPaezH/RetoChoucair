#Author: eapaezh@correo.udistrital.edu.co

@retoChoucair
Feature: Prueba de ingreso Choucair


@CP3040M
  Scenario Outline: CP2040M_Validar compra de productos con cliente recien registrado.
 
    Given Ingresar a la pagina web
    When seleccionar sign in
    And diligenciar registro de usuario <EmailAddress> <Password> <State> <PostalCode>
    And realizar compra de productos populares <cantidad> 

    Examples: 
      | EmailAddress | Password         | State                                       | PostalCode | cantidad |
      ##@externaldata@./src/test/resources/dataDriven/Main.xlsx@CP2040M
|"pruas32Cho@yaoo.com"|"12345"|"Florida"|"33124"|"3"|

