#Author: eapaezh@correo.udistrital.edu.co
@ContactUs
Feature: Menu Superior

  @CP1060M
  Scenario Outline: CP1060M_Validar un registro de contacto correcto con todos los campos diligenciados
    Given Ingresar a la pagina web
    When seleccionar contact us
    And realizar registro completo <SubjectHeading> <EmailAddress> <OrderReference> <AttachFile> <Menssage>
    Then verificar registro exitoso

    Examples: 
      | SubjectHeading | EmailAddress        | OrderReference | AttachFile                           | Menssage                                       |
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP1060M
|"Webmaster"|"pruebas@gmail.com"|"77896AH"|"D:\\Imagenes\\mensaje Receptor.png"|"No se registra mi pago 23442#45."|
|"Customer service"|"customer@gmail.com"|"6986086986"|"D:\\Imagenes\\mensaje Receptor.png"|"Realice 1 pedido el cual no he recibido aun."|



  @CP1070M
  Scenario Outline: CP1070M_Validar un registro de contacto correcto sin referencia y/o sin archivo adjunto
    Given Ingresar a la pagina web
    When seleccionar contact us
    And realizar registro incompleto <SubjectHeading> <EmailAddress> <Menssage>
    Then verificar registro exitoso

    Examples: 
      | SubjectHeading | EmailAddress        | Menssage                                       |
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP1070M
|"Webmaster"|"automation@google.com"|"No puedo ingresar a la opcion !%"|
|"Customer service"|"hola@prueba.com"|"Mi pedido no aparece en envio 152"|


@CP1090M
  Scenario Outline: CP1090M_Validar un registro de contacto diligenciando incorrectamente cualquiera de los campos (obligatorios).
    Given Ingresar a la pagina web
    When seleccionar contact us
    And realizar registro completo por mal <SubjectHeading> <EmailAddress> <OrderReference> <AttachFile> <Menssage>
    Then verificar registro fallido

    Examples: 
      | SubjectHeading | EmailAddress        | OrderReference | AttachFile                           | Menssage                                       |
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP1090M
|"Webmaster"|"pruebas@gmail.com"|"77896AH"|"D:\\Imagenes\\mensaje Receptor.png"|""|
|"Customer service"|"ohoh.com"|"6986086986"|"D:\\Imagenes\\mensaje Receptor.png"|""|

@CP1100M
  Scenario Outline: CP1090M_Validar un registro de contacto diligenciando incorrectamente cualquiera de los campos (obligatorios).
    Given Ingresar a la pagina web
    When seleccionar contact us
    And realizar registro incompleto por mal <SubjectHeading> <EmailAddress> <Menssage>
    Then verificar registro fallido

    Examples: 
      | SubjectHeading | EmailAddress         | Menssage                                       |
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP1100M
|"Webmaster"|"automationgoogle.com"|"No puedo ingresar a la opcion !%"|
|"Customer service"|"hiol.com"|""|



@CP2040M
  Scenario Outline: CP2040M_Validar el registro de un usuario en la plataforma.
    Given Ingresar a la pagina web
    When seleccionar sign in
    And diligenciar registro de usuario <EmailAddress> <Password> <State> <PostalCode>
    Then verificar registro de usuario exitoso

    Examples: 
      | EmailAddress | Password         | State                                       | PostalCode |
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP2040M
|"prueas2020Cho@yahoo.com"|"12345"|"Florida"|"33124"|


@CP2050M
  Scenario Outline: CP2050M_Validar el registro fallido cuando se ingresan datos errados
    Given Ingresar a la pagina web
    When seleccionar sign in
    And diligenciar registro de usuario <EmailAddress> <Password> <State> <PostalCode>
    Then verificar registro de usuario fallido

    Examples: 
      | EmailAddress | Password         | State                                       | PostalCode |
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP2050M
|"pruebas2022Cho@yahoo.com"|"345"|"Florida"|"545433124"|


@CP2060M
  Scenario Outline: CP2060M_Validar login exitoso
    Given Ingresar a la pagina web
    When seleccionar sign in
    And escribir usuario y contraseña <EmailAddress> <Password>
    Then verificar ingreso exitoso

    Examples: 
      | EmailAddress | Password         | 
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP2060M
|"pruebas2020Cho@yahoo.com"|"12345"|


@CP2070M
  Scenario Outline: CP2070M_Validar login fallido
    Given Ingresar a la pagina web
    When seleccionar sign in
    And escribir usuario y contraseña <EmailAddress> <Password>
    Then verificar ingreso fallido

    Examples: 
      | EmailAddress | Password         | 
      ##@externaldata@./src/test/resources/dataDriven/MenuSuperior.xlsx@CP2070M
|"pruebas2020Cho@yahoo.com"|"3664781"|
