package org.netbeans.modules.multilangsourcefilepalette.python.Variables.Variable;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.openide.text.ActiveEditorDrop;

public class Variable implements ActiveEditorDrop {

    private String varName = "";
    private String varBody = "";
    private String varType = "";

    public Variable() {
    }

    private String createBody() {
        varName = getVarName();
        varBody = getVarBody();
        if (varType.equals("String")){
        String Variable = String.format("%s = '%s'", varName, varBody);
        return Variable;
        }
        String Variable = String.format("%s = %s", varName, varBody);
        return Variable;
    }

    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {

        VariableCustomizer c = new VariableCustomizer(this, targetComponent);
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

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getVarBody() {
        return varBody;
    }

    public void setVarBody(String varBody) {
        this.varBody = varBody;
    }

    public String getVarType() {
        return varType;
    }

    public void setVarType(String varType) {
        this.varType = varType;
    }

}
