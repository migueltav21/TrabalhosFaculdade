let $voos := doc("voos.xml")//voo
let $dataDesejada := "2021-08-30"
let $destinoDesejado := "NPL"
let $resultado :=count($voos[data = $dataDesejada and destino = $destinoDesejado])
return $resultado