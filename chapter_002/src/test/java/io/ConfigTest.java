package io;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenCheckLoad() {
        String path = "src/main/data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Ivan"));
        assertThat(config.value("city"), is("Moscow"));
        assertThat(config.value("postcode"), is("111222"));
        assertThat(config.value("//"), is(nullValue()));
        assertThat(config.value("  "), is(nullValue()));
    }
}