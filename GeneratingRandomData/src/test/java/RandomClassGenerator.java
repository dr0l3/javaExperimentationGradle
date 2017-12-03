import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RandomClassGenerator extends Generator<RandomClass> {
    private List<RandomClass> cornerCases;
    private int number = 0;
    public RandomClassGenerator() {
        super(RandomClass.class);
        try {
            cornerCases = new ArrayList<>(new Runner().createCornerCases(RandomClass.class));
            Collections.shuffle(cornerCases);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public RandomClass generate(SourceOfRandomness random, GenerationStatus status) {
        if(number < cornerCases.size()){
            return cornerCases.get(number);
        } else {
            return null;
        }
    }
}
