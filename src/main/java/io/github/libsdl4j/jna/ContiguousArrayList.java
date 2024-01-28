package io.github.libsdl4j.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.*;
import java.util.function.Consumer;

/**
 * A {@link List} of JNA {@link Structure} objects allocated so that they hold a single contiguous block of native memory.
 *
 * <p>It is a Java-style replacement for a raw {@link Pointer}, to be used in place of C-style array. Such as {@code SDL_Point *points}.</p>
 *
 * <p>Automatically instantiates all Java objects and allocates a contiguous block of native memory for them.</p>
 *
 * <p>Adheres to the {@link List} interface but disallows replacement or removal of any Java objects.
 * It is supposed that the client programmer will just change fields in the Java objects.</p>
 *
 * <h2>Sample usage:</h2>
 * <pre>
 * ContiguousArrayList&lt;SDL_Rect&gt; rectangleList = new ContiguousArrayList&lt;&gt;(SDL_Rect.class, 3);
 * rectangleList.get(0).x = 0;
 * rectangleList.get(0).y = 0;
 * rectangleList.get(0).w = 10;
 * rectangleList.get(0).h = 10;
 * rectangleList.get(1).x = 100;
 * rectangleList.get(1).y = 150;
 * rectangleList.get(1).w = 20;
 * rectangleList.get(1).h = 20;
 * rectangleList.get(2).x = 400;
 * rectangleList.get(2).y = 300;
 * rectangleList.get(2).w = 40;
 * rectangleList.get(2).h = 40;
 *
 * SDL_RenderDrawRects(renderer, rectangleList);
 * </pre>
 *
 * @param <T> type of the Structure. Such as {@link io.github.libsdl4j.api.rect.SDL_Rect SDL_Rect}
 *            or {@link io.github.libsdl4j.api.messagebox.SDL_MessageBoxButtonData SDL_MessageBoxButtonData}.
 */
public final class ContiguousArrayList<T extends Structure> implements List<T> {

    private final T[] array;

    /**
     * Instantiate new array of Java objects and allocate new managed memory for them.
     *
     * @param structureClass type (descendant of {@link Structure}) for the internal array items to be instantiated
     * @param size           number of items for the array
     */
    @SuppressWarnings("unchecked")
    public ContiguousArrayList(Class<T> structureClass, int size) {
        if (size < 1) {
            throw new IllegalArgumentException("The list must be at least of size 1");
        }
        T firstItem = Structure.newInstance(structureClass, Pointer.NULL);
        array = (T[]) firstItem.toArray(size);
    }

    // TODO: How about introducing an additional constructor: ContiguousArrayList(Class<T> structureClass, int size, existingPointer);

    @Override
    public T get(int index) {
        return array[index];
    }

    public void autoWrite() {
        array[0].autoWrite();
    }

    public Pointer getPointer() {
        return array[0].getPointer();
    }

    public Pointer autoWriteAndGetPointer() {
        autoWrite();
        return getPointer();
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length, Object[].class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S> S[] toArray(S[] a) {
        int size = size();
        if (a.length < size)
            return Arrays.copyOf(this.array, size,
                    (Class<? extends S[]>) a.getClass());
        System.arraycopy(this.array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliterator(array, Spliterator.ORDERED);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T e : array) {
            action.accept(e);
        }
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        T[] a = this.array;
        if (o == null) {
            for (int i = 0; i < a.length; i++)
                if (a[i] == null)
                    return i;
        } else {
            for (int i = 0; i < a.length; i++)
                if (o.equals(a[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            return -1;
        } else {
            for (int i = array.length - 1; i >= 0; i--)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListItr(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class Itr implements Iterator<T> {
        /**
         * Index of element to be returned by subsequent call to next.
         */
        int cursor = 0;

        /**
         * Index of element returned by most recent call to next or
         * previous.  Reset to -1 if this element is deleted by a call
         * to remove.
         */
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != size();
        }

        public T next() {
            try {
                int i = cursor;
                T next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ListItr extends Itr implements ListIterator<T> {
        ListItr(int index) {
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public T previous() {
            try {
                int i = cursor - 1;
                T previous = get(i);
                lastRet = cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }
}
