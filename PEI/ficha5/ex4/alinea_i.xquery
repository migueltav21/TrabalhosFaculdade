let $reserva := doc("voos.xml")//reserva[@id = "1"]
let $passageiro := doc("voos.xml")//passageiro[numeroPassaporte = $reserva/@passaporte]
return $passageiro/nome