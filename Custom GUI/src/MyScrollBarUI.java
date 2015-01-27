
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.plaf.metal.MetalScrollBarUI;

public class MyScrollBarUI extends MetalScrollBarUI {

    private JButton b = new JButton() {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };
    
    

    public enum ScrollBarOrientation {

        HORIZONTAL {
            int getThickness(Dimension size) {
                return size.height;
            }
            int getLength(Dimension size) {
                return size.width;
            }
            int getPosition(Point point) {
                return point.x;
            }
            Rectangle updateBoundsPosition(Rectangle bounds, int newPosition) {
                bounds.setLocation(newPosition, bounds.y);
                return bounds;
            }
            Rectangle createBounds(Component container, int position, int length) {
                return new Rectangle(position, 0, length, container.getHeight());
            }
            Rectangle createCenteredBounds(Component container, int position, int thickness, int length) {
                int y = container.getHeight() / 2 - thickness / 2;
                return new Rectangle(position, y, length, thickness);
            }
        },

        VERTICAL {
            int getThickness(Dimension size) {
                return size.width;
            }
            int getLength(Dimension size) {
                return size.height;
            }
            int getPosition(Point point) {
                return point.y;
            }
            Rectangle updateBoundsPosition(Rectangle bounds, int newPosition) {
                bounds.setLocation(bounds.x, newPosition);
                return bounds;
            }
            Rectangle createBounds(Component container, int position, int length) {
                return new Rectangle(0, position, container.getWidth(), length);
            }
            Rectangle createCenteredBounds(Component container, int position, int thickness, int length) {
                int x = container.getWidth() / 2 - thickness / 2;
                return new Rectangle(x, position, thickness, length);
            }
        };

        /**
         * Get's the thickness of the given size. Thickness corresponds to the dimension that does not
         * vary in size. That is, a horizontal scroll bar's thickness corresponds to the y dimension,
         * while a vertical scroll bar's thickness corresponds to the x dimension.
         *
         * @param size the 2-dimensional size to extract the thickness from.
         * @return the thickness of the given size.
         */
        abstract int getThickness(Dimension size);

        /**
         * Get's the length of the given size. Length corresponds to the dimension that varies in size.
         * That is, a horizontal scroll bar's length corresponds to the x dimension, while a vertical
         * scroll bar's length corresponds to the y dimension.
         *
         * @param size the 2-dimensional size to extract the length from.
         * @return the length of the given size.
         */
        abstract int getLength(Dimension size);

        /**
         * Get's the position from the given {@link Point}. Position refers to the dimension of a point
         * on which the scroll bar scrolls. That is, a horiztonal scroll bar's position corresponds to
         * the x dimension, while a vertical scroll bar's position corresponds to the y dimension.
         *
         * @param point the {@code Point} from which to extrac the position from.
         * @return the position value of the given {@code Point}.
         */
        abstract int getPosition(Point point);

        /**
         * Moves the given bounds to the given position. For a horiztonal scroll bar this translates
         * into {@code bounds.x = newPosition}, while for a vertical scroll bar this translates into
         * {@code bounds.y = newPosition}.
         *
         * @param bounds      the bounds to update with the new position.
         * @param newPosition the new position to set the bounds to.
         * @return the updated bounds.
         */
        abstract Rectangle updateBoundsPosition(Rectangle bounds, int newPosition);

        /**
         * Creates bounds based on the given {@link Component}, position and length. The supplied
         * component will be used to determine the thickness of the bounds. The position will be used
         * to locate the bounds along the scrollable axis. The length will be used to determine the
         * length of the bounds along the scrollable axis.
         * Horizontal scroll bars, the bounds will be derived like this:
         *     new Rectangle(position, 0, length, container.getHeigth())
         * Vertical scroll bar bounds will be derived like this:
         *     new Rectangle(0, container.getWidth(), position, length)
         *
         * @param container the {@code Component} to use to determine the thickness of the bounds.
         * @param position  the position of the bounds.
         * @param length    the length of the bounds.
         * @return the created bounds.
         */
        abstract Rectangle createBounds(Component container, int position, int length);

        /**
         * Creates bounds centered in the given {@link Component} located at the given position, with
         * the given thickness and length.
         * Horizontal scroll bars, the bounds will be derived like this:
         *       new Rectangle(position, container.getHeight()/2 - thickness/2, length, thickness)
         * Vertical scroll bars, the bounds will be derived like this:
         *     new Rectangle(container.getWidth()/2 - thickness/2, position, thickness, length)
         *
         * @param container the {@code Component} to use to determine the thickness of the bounds.
         * @param position  the position of the bounds.
         * @param thickness the thickness of the given bounds.
         * @param length    the length of the bounds.
         * @return the created bounds.
         */
        abstract Rectangle createCenteredBounds(Component container, int position, int thickness, int length);

    }
    
    /**
     * An interface that allows implementors to control the appearance of a 
     * {@link JScrollBar}.
     */
    public interface ScrollBarSkin {

        /**
         * Called once at the begining of the skin's life cycle. Implementors 
         * should add components that will later be controlled in 
         * {@link #layoutTrackOnly(JScrollBar, ScrollBarOrientation)} and 
         * {@link #layoutEverything(JScrollBar, ScrollBarOrientation)}.
         *
         * @param scrollBar the {@link JScrollBar} that the skin will be painting.
         */
        void installComponents(JScrollBar scrollBar);

        /**
         * Called once at the begining of the skin's life cycle. Implementors should 
         * attach these mouse listners to the controls that decrement and increment 
         * the scroll bar's value.
         *
         * @param decrementMoustListener the {@link MouseListener} to be notified
         *        when a control is pressed that should result in the scroll bar's 
         *        value decrementing.
         * @param incrementMouseListener the {@link MouseListener} to be notified
         *        when a control is pressed that should result in the scroll bar's 
         *        value incrementing.
         */
        void installMouseListenersOnButtons(MouseListener decrementMoustListener,
                                            MouseListener incrementMouseListener);

        /**
         * Called when only the track should be laid out by the skin. This occurs when a
         * {@link JScrollBar} has been set to 
         * {@link javax.swing.JScrollPane#VERTICAL_SCROLLBAR_ALWAYS} or 
         * {@link javax.swing.JScrollPane#HORIZONTAL_SCROLLBAR_ALWAYS} and the
         * corresponding view is showing all the content. Note that there are, in fact, no
         * restrictions on what this method lays out. That is, if this skin wishes to layout 
         * more than just an empty track when there is no content to scroll, it may do so.
         *
         * @param scrollBar the {@link JScrollBar} that the skin is painting.
         * @param orientation the orientation of the scroll bar.
         */
        void layoutTrackOnly(JScrollBar scrollBar, ScrollBarOrientation orientation);

        /**
         * Called when the scroll bar should be laid out by the skin.
         *
         * @param scrollBar   the {@link JScrollBar} that the skin is painting.
         * @param orientation the orientation of the scroll bar.
         */
        void layoutEverything(JScrollBar scrollBar, ScrollBarOrientation orientation);

        /**
         * The smallest size that the scroll thumb can be.
         *
         * @return the mimimum size of the scroll thumb.
         */
        Dimension getMinimumThumbSize();

        /**
         * The preferred size of the painter, which will control the preferred size of the
         * associated {@link JScrollBar}. For vertical scroll bars, this value will drive the 
         * width. For horizontal scroll bars, this value will drive the height.
         *
         * @return the preferred size of this painter, and thus the corresponding 
         * {@code JScrollBar}.
         */
        Dimension getPreferredSize();

        /**
         * Gets the current bounds of the scroll thumb, which are controlled by the layout
         * provided by this skin.
         *
         * @return the current bounds of the scroll thumb.
         */
        Rectangle getScrollThumbBounds();

        /**
         * Sets the bounds of the scroll thumb. This method will be called, for example, 
         * when the associated {@link JScrollBar}'s {@link javax.swing.BoundedRangeModel}
         * is updated.
         *
         * @param bounds the new bounds of the scroll thumb.
         */
        void setScrollThumbBounds(Rectangle bounds);

        /**
         * Gets the current bounds of the track, which are controlled by the layout 
         * provided by this skin. Note that the bounds returned by this method should be
         * the actual scrollable bounds that the scroll thumb can move in. That is, this 
         * value should not just return the bounds of the associated {@link JScrollBar}, but
         * only the bounds that are valid for the scroll thumb to exist in.
         *
         * @return the current bounds of the track.
         */
        Rectangle getTrackBounds();
    }
}