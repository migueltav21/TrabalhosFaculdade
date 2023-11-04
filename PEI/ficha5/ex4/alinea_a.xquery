let $passageiros := doc("voos.xml")//passageiro
return distinct-values($passageiros//pais)
