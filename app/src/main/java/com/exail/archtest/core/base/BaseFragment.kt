package com.exail.archtest.core.base

import androidx.fragment.app.Fragment
import com.exail.archtest.core.Analytics
import org.koin.android.ext.android.inject

open class BaseFragment : Fragment() {

    internal val analytics : Analytics by inject()

}