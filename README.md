# ListenScrollView
#带滑动监听的scrollview  支持快速滑动 可以实现类似qq中空间动态的效果
#具体的使用如下：
		sv_all.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScroll(int scrollY) {
				if (scrollY > rl_top.getHeight()) {
					rl_back.setBackgroundColor(Color.parseColor("#64000000"));
				} else {
					rl_back.setBackgroundColor(Color.TRANSPARENT);

				}

			}

		});
		rl_top是布局中的控件
