/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.multilangsourcefilepalette.python.InputOutput.Print;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.openide.text.ActiveEditorDrop;

public class Print implements ActiveEditorDrop {

    private String print = "";

    public Print() {
    }

    private String createBody() {
        String Print = String.format("print '%s'", getPrint());
        return Print;
    }

    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {

        PrintCustomizer c = new PrintCustomizer(this, targetComponent);
        boolean accept = c.showDialog();
        if (accept) {
            String body = createBody();
            try {
                PaletteUtilities.insert(body, targetComponent);
            } catch (BadLocationException ble) {
                accept = false;
            }
        }

        return accept;

    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }
    
}

