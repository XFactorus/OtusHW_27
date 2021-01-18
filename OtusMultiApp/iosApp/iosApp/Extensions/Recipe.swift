//
//  Recipe.swift
//  iosApp
//
//  Created by Vladyslav Pokryshka on 18.01.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

extension Recipe: Identifiable {
    public var id: String { return href }
}
