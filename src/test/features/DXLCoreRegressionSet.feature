@DXLCore
Feature: DXLCore

  @CORE-TC0001
  Scenario: Kargo sürecinin başlanması için createShipment metotu tetiklenmesi
    Given "createShipment" metodu tüm alanlar doğru, ShipmentRefNo "REFV0002" ve ShipmentCompany "5" olacak şekilde gönderilerek "POST" edilir.

  @CORE-TC0002
  Scenario Outline: Kargo sürecinin başlanması için createShipment metotunda fromAddreste text alanının eksik olması durumu
    Given "createShipment" metodu fromAddress alanındaki text alanı boş, ShipmentRefNo "REFV0002" ve ShipmentCompany "5" olarak "POST" edilir.
    Then "<expectedResultSuccessful>" ve "<expectedResultDesc>" alanları kontrol edilir.
    Examples:
      | expectedResultSuccessful | expectedResultDesc                             |
      | false                    | Length of ShipperAddress must be between 3-255 |

  @CORE-TC0003
  Scenario Outline: Kargo sürecinin başlanması için createShipment metotunda toAddreste text alanının eksik olması durumu
    Given "createShipment" metodu toAddress alanındaki text alanı boş, ShipmentRefNo "REFV0002" ve ShipmentCompany "5" olarak "POST" edilir.
    Then "<expectedResultSuccessful>" ve "<expectedResultDesc>" alanları kontrol edilir.
    Examples:
      | expectedResultSuccessful | expectedResultDesc                               |
      | false                    | Length of ConsigneeAddress must be between 3-255 |

  @CORE-TC0004
  Scenario Outline: Kargo sürecinin başlanması için createShipment ref no olmadan metotun tetiklenmesi
    Given "createShipment" metodu tüm alanlar doğru, ShipmentRefNo "" (bos) ve ShipmentCompany "5" olacak şekilde gönderilerek "POST" edilir.
    Then "<expectedResultSuccessful>" alanı kontrol edilir.
    Examples:
      | expectedResultSuccessful |
      | true                     |

  @CORE-TC0012
  Scenario: Kargonun iade edilmesi CreateShipment
    Given "createShipment" iade metodu tüm alanlar doğru, ShipmentRefNo "1510001377" ve ShipmentCompany "5" olacak şekilde gönderilerek "POST" edilir.


    #@CORE-TC0005
  #Scenario Outline: Kargonun pending statüsünün kontrolu
  #  Given "createShipment" metodu tüm alanlar doğru, ShipmentRefNo "REFV0002" ve ShipmentCompany "5" olacak şekilde gönderilerek "POST" edilir.
  #  Given "shipmentStatus" metodu shipmentCompany "5" olarak "POST" edilir.
  #  Then "<expectedStatus>" alanının ne olduğu kontrol edilir.
  #  Examples:
  #    | expectedStatus |
  #    | PENDING        |
  #
  #@CORE-TC0009
  #Scenario Outline: Kargonun teslim edildi statü  kontrolu
  #  Given "createShipment" metodu tüm alanlar doğru, ShipmentRefNo "REFV0005" ve ShipmentCompany "5" olacak şekilde gönderilerek "POST" edilir.
  #  Given "shipmentStatus" metodu shipmentCompany "5" olarak "POST" edilir.
  #  Then "<expectedStatus>" alanının ne olduğu kontrol edilir.
  #  Examples:
  #    | expectedStatus |
  #    | DELIVERED      |
  #
  #
  #@CORE-TC0011
  #Scenario Outline: Kargonun iade edildi statü  kontrolu
  #  Given "createShipment" metodu tüm alanlar doğru, ShipmentRefNo "REFV0009" ve ShipmentCompany "5" olacak şekilde gönderilerek "POST" edilir.
  #  Given "shipmentStatus" metodu shipmentCompany "5" olarak "POST" edilir.
  #  Then "<expectedStatus>" alanının ne olduğu kontrol edilir.
  #  Examples:
  #    | expectedStatus |
  #    | RETURNED       |