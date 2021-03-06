package org.boofcv.android;

import android.os.Bundle;
import boofcv.abst.feature.detect.interest.ConfigGeneralDetector;
import boofcv.abst.feature.tracker.PointTracker;
import boofcv.factory.feature.tracker.FactoryPointTracker;
import boofcv.struct.image.ImageSInt16;
import boofcv.struct.image.ImageUInt8;

/**
 * Displays KLT tracks.
 *
 * @author Peter Abeles
 */
public class KltDisplayActivity extends PointTrackerDisplayActivity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();
		ConfigGeneralDetector config = new ConfigGeneralDetector();
		config.maxFeatures = 150;
		config.threshold = 40;
		config.radius = 3;

		PointTracker<ImageUInt8> tracker =
				FactoryPointTracker.klt(new int[]{1,2,4},config,3,ImageUInt8.class, ImageSInt16.class);

		setProcessing(new PointProcessing(tracker));
	}
}