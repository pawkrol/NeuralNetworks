# Podstawy Sztucznej Inteligencji - Paweł Król
###### AGH 2016/2017

[PL] <br>
W pakiecie `org.pawkrol.academic.nn` znajdują się podpakiety z numerem zajęć.<br>
W tych podpakietach znajduje się kod odpowiadający zadaniu przeznaczonemu na te zajęcia.<br>
<br>
W katalogu `wykresy` znajdują się zrzuty ekranu przedstawiające działanie zaimplementowanych algorytmów.<br>
Zrzuty również znajdują się w katalogach o nazwach odpowiadających numerom zajęć.<br>
<br>
[ENG] <br>
This is an academic project for AGH University in Cracow. Some of the content in this repository may be in polish language.<br>
In catalogue `wykresy` one can find a screenshots of the working applications.<br>

## Zajęcia 1 - Neuron McCullocha-Pittsa (*Zaj1*)
Losowanych jest 1000 punktów oraz dokonywany jest ich podział ze w zależności od położenia względem wykresu (pod linią wykresu funkcji `f(x) = dlugość_okna/szerokość_okna * x`, punkty niebieskie, nad funkcją punkty czerwone)<br>
    Po kliknięciu przycisku *Add* dodany zostaje losowy punkt i przyznany zostaje mu kolor (żółty - pod wykresem, zielony - nad wykresem) przez nauczony perceptron.<br><br>
    Katalog `wykresy\zaj1` zawiera dwa zrzuty ekranu: <br>
     1. *przed_dodaniem_punktow.png* pokazuje aplikację po nauczeniu perceptronu i prezentuje listę 1000 punktów (na których przebiegało uczenie) <br>
     2. *po_dodaniu_punktow.png* pokazuje aplikację po nauczeniu perceptronu oraz po dodaniu 100 losowych punktów. Przedstawia nauczony percpetron <br>

## Zajęcia 2 - Backpropagation - propagacja wsteczna (*Zaj2*)
Podejmowana jest próba nauki sieci działania bramki XOR. Podczas nauki zapisywany jest błąd i czas nauki, dane te przedstawione są na wykresie `xor_mlp_chart.png` w katalogu `wykresy\zaj2`.

## Zajęcia 3 - Uczenie Hebba (*Zaj3*)
Przedstawiane są sieci dane w postaci wektora przedstawiającego obrazy "kółko" i "krzyżyk", następnie po nauce sieci przedstawiane są te same obrazy lecz zaszumione. Sieć ma zadanie dopasować przedstawiony obraz do znanego wzorca.
Dane wejściowe są zwizualizowane w pliku `wykresy\zaj3\hebb_supervised_input_visualization.txt` 

## Zajęcia 4 - Uczenie Kohonena (*Zaj4*)
Sieci przedstawiane jest 8 różnych kolorów. Sieć działa w trybie WTA, jej zadaniem jest pogrupowanie kolorów zapisanych w 3 wymiarach (czerowny, zielony, niebieski) i przedstawienie jej jako mapy 2D. Sieć losuje wektor wejściowy, następnie oblicza odległość do każdego z neuronów i aktualizuje najbliższy jemu neuron.
Wynik działania (wizualizacja mapy) znajduje się w pliku `wykresy\zaj4\kohonen_window_wta_8_colors.png`, natomiast wykres błędu od czasu działania sieci, w pliku `wykresy\zaj4\kohonen_chart_wta_8_colors.png`.

## Zajęcia 5 - Uczenie Hopfielda (*Zaj5*)
Wejściem sieci są litery alfabetu reprezentowane jako obraz binarny, czarny kolor to stan = 1, biały to stan = -1. Sieć uczy się wzorców reprezentowanych przez dane wejściowe. Następnie wyświetlane jest okno z losowym wzorcem, który losowany jest z danych wejściowych. Wzorzec ten przed wyświetleniem jest zaszumiony. Następnie za pomocą przycisku "async" losowany jest neuron i zostaje aktywowany, za pomocą przycisku "sync" aktualizowane są wszystkie neurony. W katalogu `wykresy\zaj5` znajdują się zrzuty działania aplikacji, pliki zawierają wzorzec przed przepuszczeniem przez sieć ("before") oraz po przepuszczeniu ("after") 
