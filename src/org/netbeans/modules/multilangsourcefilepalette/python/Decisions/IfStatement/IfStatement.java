package org.netbeans.modules.multilangsourcefilepalette.python.Decisions.IfStatement;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.openide.text.ActiveEditorDrop;

public class IfStatement implements ActiveEditorDrop {

    private String ifCondition = ""; 
    private String ifBody = ""; 

    public IfStatement() {
    }

    private String createBody() {
        String IfStatement = String.format("if %s:"
                + "\n    %s", getIfCondition(), getIfBody());
        return IfStatement;
    }

    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {

        IfStatementCustomizer c = new IfStatementCustomizer(this, targetComponent);
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

    public String getIfCondition() {
        return ifCondition;
    }

    public void setIfCondition(String ifCondition) {
        this.ifCondition = ifCondition;
    }

    public String getIfBody() {
        return ifBody;
    }

    public void setIfBody(String ifBody) {
        this.ifBody = ifBody;
    }



}

