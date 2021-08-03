/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myseleniumdemo;

import java.awt.AWTException;



/**
 *
 * @author MMkolwe
 */
public class TestScript {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException, AWTException {
    //initializing an instance of the PracticeTest
        PracticeTesting sadcPortalTest = new PracticeTesting();
        sadcPortalTest.setUp();
        sadcPortalTest.loginTest();
        sadcPortalTest.navigationTest();
        sadcPortalTest.accountCreationTest();
        sadcPortalTest.testLogout();
        sadcPortalTest.tearDown();
//          MyTest testyoutube = new MyTest();
//          testyoutube.setUp();
//          testyoutube.realTest();
//          testyoutube.tearDown();        
    }
    
}
