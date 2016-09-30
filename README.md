#Info

The goal of this library is to find all possible variations of any data array. For example if you want to know all variations of 3 elements each of which can take the value from 0-2.

Just fill input data
```
        List<List<Integer>> allPossibleVariations = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            List<Integer> variation = new ArrayList<>();
            for (int j = 0; j < 10; ++j) {
                variation.add(j);
            }
            allPossibleVariations.add(variation);
        }
```

then pass it to `getAllVariations` method
```
        Variation<Integer> variation = new Variation<>();
        Set<List<Integer>> result = variation.getAllVariations(allPossibleVariations);
```
and you will get the result:

```
0 0 0 
0 0 1 
0 0 2 
0 1 0 
0 1 1 
0 1 2 
0 2 0 
0 2 1 
0 2 2 
1 0 0 
1 0 1 
1 0 2 
1 1 0 
1 1 1 
1 1 2 
1 2 0 
1 2 1 
1 2 2 
2 0 0 
2 0 1 
2 0 2 
2 1 0 
2 1 1 
2 1 2 
2 2 0 
2 2 1 
2 2 2 
```

This library can cope with any size of input data. The only limitation is your computing power ;)

 
