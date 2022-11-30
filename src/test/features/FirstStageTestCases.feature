Feature: FirstStageTestCases

  #The feature file contains:

  # 1)Fatura Ödeme
  #	2)Fatura Ödeme İptali
  # 3)Ön otorizasyon
  #	4)Kolay paket satışı
  #	5)Kolay paket iptali


  @Test001
  Scenario Outline: KolaypackPreauth POST service control
    Given createPaytionToken service is sent and take the token
    And KolayPackPreAuth "POST" request "<transactionId>", "<transactionGroupId>" , "<reconDate>", "<ipAddress>" , "<companyId>" , "<institutionId>" , "<productId>" , "<bankId>" , "<transactionDate>" , "<description>","<paymentMethod>","<customerReferenceType>","<sun>","<customerCode>","<installment>"

    Examples:
      | transactionId                      | transactionGroupId                       | reconDate  | ipAddress | companyId | institutionId | productId | bankId | transactionDate     | description    | paymentMethod | customerReferenceType | sun        | customerCode | installment |
      | 8bb0958a-PREAUTH-51db-bswwasd221wg | 8bb0958a-RPREAUTH-40db-be8e-c3cc2b6b1c5d | 2022-10-24 | 127.0.0.1 | 542       | 2864          | 1001      | 1111   | 2022-10-24T14:11:38 | PREAUTH ISTEGI | NORMAL        | MSISDN                | 5558799312 | 0011223344   | 0           |

