/*
 * The MIT License
 *
 * Copyright 2017 .
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

import de.targodan.usb.data.Case;
import de.targodan.usb.data.Platform;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;

/**
 *
 * @author Luca Corbatto
 */
public class CaseView extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form CaseView
     */
    public CaseView() {
        initComponents();
        
        this.initialSize = this.getPreferredSize().height;
    }
    
    public CaseView(Case c) {
        this();
        
        this.viewCase = c;
        
        this.updateCaseView();
        this.viewCase.addObserver(this);
    }
    
    protected void updateCaseView() {
        this.caseNumber.setText("#"+Integer.toString(this.viewCase.getNumber()));
        this.cmdrName.setText(this.viewCase.getClient().getCMDRName());
        this.language.setText(this.viewCase.getClient().getLanguage().toUpperCase());
        this.platform.setText(this.platformToString(this.viewCase.getClient().getPlatform()));
        this.system.setText(this.viewCase.getSystem().getName());
        
        this.ratsPanel.removeAll();
        this.ratsPanel.setLayout(new VerticalLayout());
        this.viewCase.getRats().forEach((rat) -> {
            RatView rv = new RatView(rat);
            this.ratsPanel.add(rv);
        });
        int height = Stream.of(this.ratsPanel.getComponents())
                .mapToInt(c -> c.getHeight())
                .sum();
        if(height < this.initialSize) {
            height = this.initialSize;
        }
        this.setPreferredSize(new Dimension(this.getWidth(), height));
        
        this.revalidate();
        this.repaint();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        java.awt.EventQueue.invokeLater(() -> {
            this.updateCaseView();
        });
    }
    
    protected String platformToString(Platform platform) {
        switch(platform) {
            case PC:
                return "PC";
                
            case PS4:
                return "PS4";
                
            case XBOX:
                return "XBox";
        }
        throw new IllegalArgumentException("Platform \""+platform.toString()+"\" is not supported.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        caseNumberPanel = new javax.swing.JPanel();
        caseNumber = new javax.swing.JLabel();
        cmdrNamePanel = new javax.swing.JPanel();
        cmdrName = new javax.swing.JLabel();
        languagePanel = new javax.swing.JPanel();
        language = new javax.swing.JLabel();
        platformPanel = new javax.swing.JPanel();
        platform = new javax.swing.JLabel();
        systemPanel = new javax.swing.JPanel();
        system = new javax.swing.JLabel();
        ratsPanel = new javax.swing.JPanel();
        rats = new javax.swing.JLabel();
        notesPanel = new javax.swing.JPanel();
        notes = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        caseNumberPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        caseNumberPanel.setPreferredSize(new java.awt.Dimension(40, 39));

        caseNumber.setText("Case");

        javax.swing.GroupLayout caseNumberPanelLayout = new javax.swing.GroupLayout(caseNumberPanel);
        caseNumberPanel.setLayout(caseNumberPanelLayout);
        caseNumberPanelLayout.setHorizontalGroup(
            caseNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caseNumberPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(caseNumber)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        caseNumberPanelLayout.setVerticalGroup(
            caseNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(caseNumberPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(caseNumber)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(caseNumberPanel);

        cmdrNamePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        cmdrNamePanel.setPreferredSize(new java.awt.Dimension(170, 39));

        cmdrName.setText("CMDR Name");

        javax.swing.GroupLayout cmdrNamePanelLayout = new javax.swing.GroupLayout(cmdrNamePanel);
        cmdrNamePanel.setLayout(cmdrNamePanelLayout);
        cmdrNamePanelLayout.setHorizontalGroup(
            cmdrNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmdrNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdrName)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        cmdrNamePanelLayout.setVerticalGroup(
            cmdrNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmdrNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdrName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(cmdrNamePanel);

        languagePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        languagePanel.setPreferredSize(new java.awt.Dimension(40, 39));

        language.setText("Lang");

        javax.swing.GroupLayout languagePanelLayout = new javax.swing.GroupLayout(languagePanel);
        languagePanel.setLayout(languagePanelLayout);
        languagePanelLayout.setHorizontalGroup(
            languagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(language)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        languagePanelLayout.setVerticalGroup(
            languagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(language)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(languagePanel);

        platformPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        platformPanel.setPreferredSize(new java.awt.Dimension(40, 39));

        platform.setText("Plat");

        javax.swing.GroupLayout platformPanelLayout = new javax.swing.GroupLayout(platformPanel);
        platformPanel.setLayout(platformPanelLayout);
        platformPanelLayout.setHorizontalGroup(
            platformPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(platformPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(platform)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        platformPanelLayout.setVerticalGroup(
            platformPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(platformPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(platform)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(platformPanel);

        systemPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        systemPanel.setPreferredSize(new java.awt.Dimension(200, 39));

        system.setText("System");

        javax.swing.GroupLayout systemPanelLayout = new javax.swing.GroupLayout(systemPanel);
        systemPanel.setLayout(systemPanelLayout);
        systemPanelLayout.setHorizontalGroup(
            systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(system)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        systemPanelLayout.setVerticalGroup(
            systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(system)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(systemPanel);

        ratsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        ratsPanel.setPreferredSize(new java.awt.Dimension(250, 39));

        rats.setText("Rats");

        javax.swing.GroupLayout ratsPanelLayout = new javax.swing.GroupLayout(ratsPanel);
        ratsPanel.setLayout(ratsPanelLayout);
        ratsPanelLayout.setHorizontalGroup(
            ratsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rats)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ratsPanelLayout.setVerticalGroup(
            ratsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rats)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(ratsPanel);

        notesPanel.setPreferredSize(new java.awt.Dimension(175, 39));

        notes.setText("Notes");

        javax.swing.GroupLayout notesPanelLayout = new javax.swing.GroupLayout(notesPanel);
        notesPanel.setLayout(notesPanelLayout);
        notesPanelLayout.setHorizontalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notesPanelLayout.setVerticalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(notesPanel);
    }// </editor-fold>//GEN-END:initComponents

    private Case viewCase;
    private int initialSize;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel caseNumber;
    private javax.swing.JPanel caseNumberPanel;
    private javax.swing.JLabel cmdrName;
    private javax.swing.JPanel cmdrNamePanel;
    private javax.swing.JLabel language;
    private javax.swing.JPanel languagePanel;
    private javax.swing.JLabel notes;
    private javax.swing.JPanel notesPanel;
    private javax.swing.JLabel platform;
    private javax.swing.JPanel platformPanel;
    private javax.swing.JLabel rats;
    private javax.swing.JPanel ratsPanel;
    private javax.swing.JLabel system;
    private javax.swing.JPanel systemPanel;
    // End of variables declaration//GEN-END:variables
}
