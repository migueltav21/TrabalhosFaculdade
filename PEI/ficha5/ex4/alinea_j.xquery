declare function local:nome_passageiro_por_reserva($numeroReserva) as element()*
{
let  $documento := doc("voos.xml")
let $reserva := $documento//reserva[@id = $numeroReserva]
let $passageiro := $documento//passageiro[numeroPassaporte = $reserva/@passaporte]
return $passageiro/nome
};

let $numReserva := 4
return local:nome_passageiro_por_reserva($numReserva)