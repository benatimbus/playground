package de.werling.ci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ComplexControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturn4If3and1IsAdded() throws Exception {
        assertThat(sendRequest("1", "3", '+', int.class)).isEqualTo(4);
    }

    @Test
    public void shouldReturn14If7and2AreMultiplied() throws Exception {
        assertThat(sendRequest("7", "2", '*', int.class)).isEqualTo(14);
    }

    @Test
    public void shouldReturn2If3andMinus1IsAdded() throws Exception {
        assertThat(sendRequest("-1", "3", '+', int.class)).isEqualTo(2);
    }

    @Test
    public void shouldReturn4If8OIsDividedBy2() throws Exception {
        assertThat(sendRequest("8", "2", '/', int.class)).isEqualTo(4);
    }

    private <T> T sendRequest(String left, String right, char op, Class<T> resultType){
        return this.restTemplate.getForObject("http://localhost:" + port + "/api/calculate?left="+left+"&right="+right+"&op="                +op,
                resultType);
    }
}