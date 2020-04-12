package com.form.Reactive;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MackListTests {

    @Test
    public void sizeTest() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void sizeTestMultiple() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void sizeTestMultipleParameter() {
        List mock = mock(List.class);
        when(mock.get(0)).thenReturn("hello");
        assertEquals("hello", mock.get(0));
    }

    @Test
    public void sizeTestMultipleParameterany() {
        List mock = mock(List.class);
        when(mock.get(anyInt())).thenReturn("hello");
        assertEquals("hello", mock.get(0));
    }

    @Test
    public void sizeTestMultipleParameterevrification() {
        List mock = mock(List.class);
        Object i = mock.get(0);
        verify(mock).get(0);
        verify(mock, times(1)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(1)).get(anyInt());
        verify(mock, never()).get(5);

    }

    @Test
    public void sizeTestMultipleParameterevrificationargument() {

        List mock = mock(List.class);
        mock.add("tgh");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("tgh", captor.getValue());


    }

    @Test
    public void sizeTestMultipleParameterevrificationargumentmultiple() {

        List mock = mock(List.class);
        mock.add("tgh");
        mock.add("pqr");
        System.out.println(mock.get(0));
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> argList = captor.getAllValues();
        assertEquals("tgh", argList.get(0));
        assertEquals("pqr", argList.get(1));

    }
    @Test
    public void spySample() {

        ArrayList sampleList = spy(ArrayList.class);
        sampleList.add("test");
        System.out.println(sampleList.size());
        when(sampleList.size()).thenReturn(5);
        System.out.println(sampleList.size());
       assertEquals(sampleList.size(),5);

    }
}
