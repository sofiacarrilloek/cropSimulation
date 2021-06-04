/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cropsimulation;

/**Editando lisyto
 *
 * @author AMMC
 */
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.stat.StatUtils;
import org.math.array.DoubleArray.*;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
//es

/**
 *
 * @author sofia
 */
public class INTERPOLACION {
    
    double [] x= {1, 2, 3, 4, 5, 6};
    double [] y= {500, 250, 325, 470, 840, 555};
    
    UnivariateInterpolator interpolador =new SplineInterpolator();
    Plot2DPanel plot=new Plot2DPanel();

    /**
     *
     */
    public INTERPOLACION(){
        UnivariateFunction polinomio=interpolador.interpolate(x, y);
        int n=(int) Math.abs((StatUtils.max(x)-StatUtils.min(x))/0.1);
        double[] xc=new double[n];
        double[] yc=new double[n];
        double xi=StatUtils.min(x);
        for(int i=0; i<xc.length; i++){
            xc[i]=xi+0.1*i;
            yc[i]=polinomio.value(xc[i]);
        }
        plot.addLegend("SOUTH");
        plot.addScatterPlot("Datos", x, y);
        plot.addLinePlot("Interpolación Spline", xc, yc);
        BaseLabel titulo=new BaseLabel("Interpolación Spline", Color.RED,0.5,1.1);
        plot.addPlotable(titulo);
        
        JFrame frame=new JFrame("Interpolación Spline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.add(plot,BorderLayout.CENTER);
        frame.setVisible(true);
        /*public static void main(String[] args) {
        new Interpolación();
    }*/
        //SERVIA PARA QUE SE LLAME EL MÉTODO DE UNA, PERO SE PUEDE PONER new Interpolación(); EN EL BOTÓN DONDE SE VAYA A LLAMAR LA GRÁFICA
}
}
