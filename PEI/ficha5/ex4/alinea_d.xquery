let $voos := doc("voos.xml")//voos
where $voos/voo[data = "2021-08-30"] and $voos/voo[destino = "NPL"]
return
  <resultado>
    <mensagem>Alguns voos realizados no dia 2021-08-30 tinham "NPL" como destino.</mensagem>
  </resultado>