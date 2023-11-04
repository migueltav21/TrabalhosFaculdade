let $voos := doc("voos.xml")//voo
let $dataDesejada := "2021-08-30"
let $destinoDesejado := "NPL"
let $passageiro := doc("voos.xml")//passageiros/passageiro[nome = "Santa Claus"]
let $reserva_passageiro := doc("voos.xml")//reserva[@passaporte= $passageiro/numeroPassaporte]
let $voo := $voos[data = "2021-08-30" and destino = "NPL"]
let $resultado :=
  if (($voos//data) = $dataDesejada and $voos//destino = $destinoDesejado and $reserva_passageiro/@voo = $voo/@id)
  then
    "Houve voos realizados no dia 2021-08-30 tinham 'NPL' como destino, em que o passageiro Santa Claus viajou"
  else
    "Nenhum voo com destino 'NPL'  no dia 2021-08-30 tinha como passageiro Santa Claus"

return $resultado
