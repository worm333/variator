Finds all possible variations of numbers.

For example you want to know all variations of 5 elements each of which can take the value from 0-9

0 0 0 0 0<br>
0 0 0 0 1<br>
... <br>
9 9 9 9 9 <br>

List<List<Integer>> allPossibleVariations = new ArrayList<>(); <br>
for (int i = 0; i < 5; ++i) { <br>
  List<Integer> variation = new ArrayList<>(); <br>
  for (int j = 0; j < 10; ++j) { <br>
    variation.add(j); <br>
  } <br>
  allPossibleVariations.add(variation); <br>
} <br>
Variation<Integer> variation = new Variation<>(); <br>
Set<List<Integer>> result = variation.getAllVariations(allPossibleVariations); <br>



 
