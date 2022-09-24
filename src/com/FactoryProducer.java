package com;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean Registered){   
      if(Registered){
         return new RegisteredTicketFactory();         
      }else{
         return new UnregisteredTicketFactory();
      }
   }
}