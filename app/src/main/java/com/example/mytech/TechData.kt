package com.example.mytech

object TechsData {
    private val techNames = arrayOf(
        "ASUS ProArt StudioBook Pro 15",
        "ASUS TUF Gaming A15 FX506II",
        "HP Omen 15-ce503TX"
    )


    private val techDetails = arrayOf(
        "Seri ASUS StudioBook adalah pembangkit tenaga listrik perkasa yang menghidupkan ide. Dilengkapi dengan NVIDIA® Quadro GPU, dan menawarkan layar NanoEdge dengan bingkai tipis untuk visual yang imersif. Kombinasi grafis mutakhir dan portabilitas membuatnya sempurna untuk para profesional kreatif",
        "ASUS TUF Gaming A15 FX506 merupakan laptop gaming yang memiliki performa dan juga durabilitas tinggi. Laptop ini sangat cocok untuk gamers profesional yang ingin memenangkan pertandingan. Kemudian, laptop ASUS TUF Gaming A15 memiliki ukuran 359.8 x 256 x 22.8 – 24.7 mm dan berat sekitar 2.3 Kg. Laptop ini hadir dengan sasis yang lebih ringan dan ringkas dibandingkan dengan seri pendahulunya. Tak hanya itu saja, ASUS TUF Gaming A15 FX506 dibekali dengan baterai besar yang bertujuan agar Anda dapat menggunakan laptop ini untuk waktu yang lama yakni hingga mencapai 8.7 jam. Meskipun performanya kencang, laptop ini tetap tampil estetis. Laptop gaming ASUS ini tampil sangat elegan dan juga sleek. Tentu ada kelebihan lain yang ditawarkan oleh laptop gaming ASUS TUF Gaming A15 FX506",
        "Laptop gaming HP Omen 15 dilengkapi spesifikasi tangguh dan desain bernuansa gaming. Bodi laptop yang ringkas memudahkan Anda bermain game hardcore di mana saja. Tebal laptop 24.8 mm dan berat mulai dari 2.5 kg tentunya tidak akan menyulitkan saat ingin dibawa-bawa. Pilihan prosesor Intel® Core™ i7 dan i5 generasi ke-7 serta opsi grafis diskrit NVIDIA GeForce GTX 10 atau AMD Radeon RX mampu hadirkan pengalaman gaming yang lebih realistis. Ditambah lagi, HP Omen 15 kini sudah didukung layar monitor beresolusi tinggi supaya setiap detail grafis dapat ditampilkan sempurna. Jika Anda ingin meng-upgrade performa laptop, HP menyediakan panel tunggal untuk mengakses HDD, SSD, atau RAM laptop ini.",
    )

    private val techImages = intArrayOf(
        R.drawable.asus_proart15,
        R.drawable.asus_tuf_a15,
        R.drawable.omen_15
    )

    private val techPrice = arrayOf(
        "Rp 71.489.000",
        "Rp 21.777.360",
        "Rp 26.586.000"
    )


    val listData: ArrayList<Tech>
        get() {
            val list = arrayListOf<Tech>()
            for (position in techNames.indices) {
                val tech = Tech()
                tech.name = techNames[position]
                tech.detail = techDetails[position]
                tech.photo = techImages[position]
                tech.price = techPrice[position]
                list.add(tech)
            }
            return list
        }
}