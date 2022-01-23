# Cel repozytorium
Stworzenie prostej symulacji gry rpg

# Program „ShortStory”
Program stworzony w języku java oparty na OOP. Gracz wybiera postać z danej mu puli i wyrusza walczyć z przeciwnikami, 
jeśli mu się uda przejść pietro dostaje wyższy poziom(level, poziom doświadczenia) następnie rozdysponowywane punktami 
aby zwiększyć swoje statystyki i wyrusza na następne pietro. Z coraz wyższym poziomem potwory są mocniejsze.


## Założenia programu „Short Story”
<ol>
  <li>Postacie:
    <ul>
      <li>Do wyboru są 3 typy postaci (wojownik, łucznik, ninja)</li>
      <li>Postacie(klasy) posiadają takie statystyki jak:</li>
      <li>Gracz rozpoczyna z poziomem 0</li>
   </ul>
  </li>
  <li>Przeciwnicy(potwory):
    <ul>
     <li>Gracz może spotkać na piętrze przeciwników w zależności od posiadanego poziom bohatera.</li>
     <li>Przeciwnicy posiadają takie same rodzaje statystyk jak postacie lecz przeciwnicy różnią się tym że w typie 
     doświadczenia jest informacja ile doświadczenia dostanie gracz za zabicie go.</li>
    </ul>
  </li>
  <li>Poziom postaci wzrasta:
    <ul>
      <li>Do wbicia poziomu 1 należy zdobyć 100 punktów doświadczenia do następnych poziomów należy uzyskać 2 razy 
      więcej punktów niż za poprzedni. </li>
      <li>Gracz po skończonym piętrze może podwyższyć jedną statystykę taką jak Zdrowie Atak lub Unik.</li>
      <li>Gdy gracz dostaje wyższy poziom do gry dodawany jest kolejny przeciwnik z wyższymi statystykami.</li>
      <li>Po wbiciu kolejnego poziomu postaci przywracane jest pełne zdrowie.</li>
    </ul>
  </li>
  <li>Pietro:
    <ul>
      <li>Na piętrze losowane są potwory w zależności od poziomu gracza.</li>
      <li>Numer piętra równa się poziomowi gracza.</li>
    </ul>
  </li>
<ol>
