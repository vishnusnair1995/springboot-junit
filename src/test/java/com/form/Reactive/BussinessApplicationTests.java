package com.form.Reactive;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class BussinessApplicationTests {

    @InjectMocks
    BussinessApplication bussinessApplication;
    @Mock
    BussinessService bussinessService;

        @Before
    public void setUp() {

        bussinessApplication.setBussinessService(bussinessService);
    }
@Before
public void init() {
    MockitoAnnotations.initMocks(this);
}
    @Test
    public void methodCheckForCalculate() {
        int arraySample[] = {1, 8, 9};
        BussinessApplication bussinessApplication = new BussinessApplication();
        int result = bussinessApplication.calculate(arraySample);
        assertEquals(18, result);


    }

    @Test
    public void methodCheckForCalculateService() {

        when(bussinessService.retrieveData()).thenReturn(new int[]{1, 5});

        int result = bussinessApplication.calculateUsingService();
        int result = bussinessApplication.calculateUsingService();
        assertEquals(6, result);


    }
}
