package android.bug.apppause;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChildFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Integer>> {

    public ChildFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(0, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        if (getActivity().isFinishing()) {
            Toast.makeText(getActivity(), "onStarted called while finishing", Toast.LENGTH_SHORT).show();
        }
        super.onStart();
    }

    @Override
    public Loader<List<Integer>> onCreateLoader(int id, Bundle args) {
        return new SampleLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Integer>> loader, List<Integer> data) {
    }

    @Override
    public void onLoaderReset(Loader<List<Integer>> loader) {

    }
}
