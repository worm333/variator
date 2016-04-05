Finds all possible variations of numbers.

For example you want to know all variations of 5 elements each of which can take the value from 0-9

0 0 0 0 0
0 0 0 0 1
...
9 9 9 9 9

List<List<Integer>> allPossibleVariations = new ArrayList<>();
for (int i = 0; i < 5; ++i) {
  List<Integer> variation = new ArrayList<>();
  for (int j = 0; j < 10; ++j) {
    variation.add(j);
  }    
  allPossibleVariations.add(variation);
}
Variation<Integer> variation = new Variation<>();
Set<List<Integer>> result = variation.getAllVariations(allPossibleVariations);



 
