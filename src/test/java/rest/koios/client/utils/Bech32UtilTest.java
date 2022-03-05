package rest.koios.client.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bech32UtilTest {

    @Test
    public void invalidCharsTest() {
        Assertions.assertFalse(Bech32Util.hasValidChars(null));

        Assertions.assertFalse(Bech32Util.hasValidChars(""));

        Assertions.assertFalse(Bech32Util.hasValidChars("IQoJb3JpZ2luX2VjEJP//////////wEaCXVzLWVhc3QtMSJGMEQCIFEdcXP1FbfLBZSp1OCWP6eB6pofyWx/plHVZe4BSuUEAiAKVZYe5340wvB5uDvg/K1SbBJzvEBEyZLPDMZvlb+hjCr4AQjr//////////8BEAAaDDA1NjYxMjc1NDY1OCIMxtO9x0MsdST4bqy0KswBXPQZkMVN6+NRKkhvhkBsKnkrFn43TBFbwNJPRD0y4j2Ov1dikgpzzWGK+gff4pDec6e/vhcK0rZtQ3X7J7Id6NyoKrrt+XAzXdg8s7DWzMw6FkN0yaGIhvtqQATIkt+X5rKm0M9wwS+eNjurTQlqJdYjm94MuVCGWiQ1/xD/ZM2ECKfAV8FcnKLI+scT/kfP+weCQy1+iv8v8caS+uE8LclFINf4UOcBl4fF80vlU8qmXPVQjxXV/j9GqIwJ1+F08gEe2XbiYfHe/+g+MOXC8pAGOpkBeHgMzPDkljTJ244SO/vk1BGNNBrJeBZKLLTPsH/bynI2QSQlZcq8zreLh4GoalS+0QSRcsvPhCainLeZkxOqsK1+kfUBJpe3TW6lGLaqc8DIqUBMkhCwCbSDKWMe/o2RmlzLKZSSeJ/gABoNulUXxPpkfIBemCYi377DD5szO6dWAcLdny1FK2cZqVtRNDwh7XLpunvhMsiA"));

        Assertions.assertFalse(Bech32Util.hasValidChars("pooL1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8"));
    }
}
