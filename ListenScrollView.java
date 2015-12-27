package com.haircut.c.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ScrollView;
/**
 * 带滑动监听的scrollview
 * @author wanyan
 *
 */
public class ListenScrollView extends ScrollView {
	private OnScrollListener onScrollListener;
	private int lastScrollY;

	public ListenScrollView(Context context) {
		this(context, null);
	}

	public ListenScrollView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ListenScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * 设置滚动接口
	 * 
	 * @param onScrollListener
	 */
	public void setOnScrollListener(OnScrollListener onScrollListener) {
		this.onScrollListener = onScrollListener;
	}

	/**
	 * 回调接口中
	 */
	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			int scrollY = ListenScrollView.this.getScrollY();
			if (onScrollListener != null) {
				onScrollListener.onScroll(scrollY);
			}
		};

	};

	/**
	 * 滚动时的监听 fling
	 */
	@Override
	protected int computeVerticalScrollExtent() {
		handler.sendMessageDelayed(handler.obtainMessage(), 5);
		return super.computeVerticalScrollExtent();
	}

	/**
	 * 
	 * 滚动的回调接口
	 * 
	 */
	public interface OnScrollListener {
		/**
		 * 回调方法， 返回MyScrollView滑动的Y方向距离
		 * 
		 * @param scrollY
		 *            、
		 */
		public void onScroll(int scrollY);

	}

}
