package org.netbeans.modules.multilangsourcefilepalette.java.Comments;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.openide.text.ActiveEditorDrop;

public class InlineComment implements ActiveEditorDrop {

    public InlineComment() {
    }

    private String createBody() {

        String Comment = "//";
        return Comment;
    }

    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {
        String body = createBody();
        try {
            PaletteUtilities.insert(body, targetComponent);
        } catch (BadLocationException ble) {
            return false;
        }

        return true;

    }
}
