package com.form.Reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BussinessApplication {


    BussinessService bussinessService;
BussinessApplication(BussinessService bussinessService)
{
    this.bussinessService = bussinessService;
}
BussinessApplication()
{

}
    public BussinessService getBussinessService() {
        return bussinessService;
    }

    public void setBussinessService(BussinessService bussinessService) {
        this.bussinessService = bussinessService;
    }

    int  sum =0;
    public int calculate(int[] sampleArray)
    {
        for(int value:sampleArray)
        {
            sum = sum + value;

        }
        return sum;
    }

    public int calculateUsingService()
    {
        int cal = 0;
        int [] arrayFroomservice = bussinessService.retrieveData();
        int serviceSum = new BussinessApplication().calculate(arrayFroomservice);
        System.out.println(serviceSum);
        return serviceSum;


    }

    public static void main(String[] args) {
        BussinessApplication bussinessApplication = new BussinessApplication();
        bussinessApplication.calculateUsingService();
    }
}
