package com.waxd.camera.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import com.waxd.camera.databinding.GallerySlideBinding

class GallerySlide(val binding: GallerySlideBinding) : RecyclerView.ViewHolder(binding.root) {
    @Volatile var currentPostion = 0
}
