//package org.example;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
///**
// * Unit test for simple App.
// */
////@ExtendWith(MyCustomExtension.class)
//@SpringBootTest
//public class AppTest {
//
//   @Mock
//    private ServiceClass serviceClass;
//
//   @Autowired
//   private ServiceClass serviceClass1;
//
//    @Test
//    public  void testVoidMethod()
//    {
//        doNothing().when(serviceClass).methodWithNoResponse();
//        //serviceClass1.methodWithNoResponse();
//        verify(serviceClass,times(1)).methodWithNoResponse();
//    }
//
//    @Test
//    public void testMethodWithParameters() {
//
//        String response="returning from methodWithParameters method :Prem";
//        when(serviceClass.methodWithParameters(anyString())).thenReturn(response);
//        assertEquals(response,serviceClass1.methodWithParameters("Prem"));
//    }
//
////    @Test
////    public void testGetTrace() {
////        String givenString = "returning from private method";
////        when(serviceClass.getServiceTrace()).thenReturn(givenString);
////        assertEquals(givenString, serviceClass.getServiceTrace());
////
////    }
//
//    @Test
//    public void tesPrivateMethodTrace() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        String givenString = "returning from private method";
//
//        Method privateMethod = ServiceClass.class.getDeclaredMethod("privateMethod");
//        privateMethod.setAccessible(true);
//        String invoke = (String) privateMethod.invoke(serviceClass);
//        assertEquals(givenString, invoke);
//
//    }
//}
