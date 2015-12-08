package org.netbeans.modules.multilangsourcefilepalette.python.Decisions.SingleLineIf;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.openide.text.ActiveEditorDrop;

public class SingleLineIf implements ActiveEditorDrop {

    private String ifCondition = ""; 
    private String ifBody = ""; 

    public SingleLineIf() {
    }

    private String createBody() {
        String SingleLineIf = String.format("if ( %s ) : %s", getIfCondition(), getIfBody());
        return SingleLineIf;
    }

    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {

        SingleLineIfCustomizer c = new SingleLineIfCustomizer(this, targetComponent);
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

