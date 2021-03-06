/*
 * The MIT License
 *
 * Copyright 2017 Luca Corbatto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.targodan.usb.ui;

import de.targodan.usb.TeeOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca Corbatto
 */
public class ConsoleWindow extends javax.swing.JFrame {

    private PrintStream originalOut;
    private PrintStream originalErr;
    
    /**
     * Creates new form ConsoleWindow
     */
    public ConsoleWindow() {
        initComponents();
        
        OutputStream textAreaOutputStream = new TextAreaOutputStream(this.jTextArea1);
        
        this.originalOut = System.out;
        this.originalErr = System.err;
        
        PrintStream out;
        PrintStream err;
        try {
            out = new PrintStream(new TeeOutputStream(textAreaOutputStream, System.out), true, "UTF-8");
            err = new PrintStream(new TeeOutputStream(textAreaOutputStream, System.err), true, "UTF-8");
            
            System.setOut(out);
            System.setErr(err);
            
            this.originalOut.flush();
            this.originalErr.flush();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ConsoleWindow.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("This should never happen.");
        }
    }
    
    @Override
    public void dispose() {
        PrintStream out = System.out;
        PrintStream err = System.err;
        
        System.setOut(this.originalOut);
        System.setErr(this.originalErr);
        
        out.flush();
        out.close();
        err.flush();
        err.close();
        
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
